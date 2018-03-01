package com.yanda.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanda.component.FileConfig;
import com.yanda.entity.FileType;
import com.yanda.entity.PageResult;
import com.yanda.entity.generated.AttachmentInfo;
import com.yanda.exception.DOPException;
import com.yanda.mapper.generated.AttachmentInfoMapper;
import com.yanda.service.AttachmentService;
import com.yanda.service.BaseService;
import com.yanda.util.ImageUtils;


/**
 * 附件处理服务类
 * AttachmentServiceImpl.java
 * @author chenli
 * @time 2018年3月1日 下午5:18:24
 */
@Service
public class AttachmentServiceImpl extends BaseService<AttachmentInfoMapper, AttachmentInfo, Long> implements AttachmentService {
	
	public final Set<Integer> iconSize = new LinkedHashSet<Integer>() {

		private static final long serialVersionUID = 1L;

		{
			add(800);
			add(500);
			add(200);
			add(80);
		}
	};
	
	@Autowired
	private FileConfig fileConfig;
	@Autowired
	private AttachmentInfoMapper attachMapper;
	
	@Transactional(rollbackFor={DOPException.class})
	@Override
	public int save(AttachmentInfo record) throws DOPException {
		String newFilename = record.getNewFilename();
		String fileExt = record.getFileExt();
		File tempFile = new File(fileConfig.getTempPath(), newFilename + "." + fileExt);
		try {
			
			String filePath = generatedFilePath(record);
			// 图片类型附件要生成缩略图
			if (FileType.IMG.getValue() == record.getFileType()) {
				generatedThumbnail(tempFile, new File(filePath), newFilename, fileExt);
			}
			File dest = new File(filePath, record.getNewFilename() + "." + record.getFileExt());
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}
			FileUtils.copyFile(tempFile, dest);
			tempFile.delete();
			return attachMapper.insertSelective(record);
			
		} catch (IOException e) {
			String tips = "添加附件失败：生成缩略图异常";
			LOG.error(tips, e);
			throw new DOPException(tips);
		} 
	}
	
	@Transactional(rollbackFor={DOPException.class})
	@Override
	public int deleteById(Long recordId) throws DOPException {
		try {
			
			AttachmentInfo attachmentInfo = attachMapper.selectByPrimaryKey(recordId);
			int result = attachMapper.deleteByPrimaryKey(recordId);
			String filePath = generatedFilePath(attachmentInfo);
			FileUtils.deleteDirectory(new File(filePath));
			return result;
			
		} catch (IOException e) {
			String tips = "删除附件异常";
			LOG.error(tips, e);
			throw new DOPException(tips);
		}
	}

	@Override
	public PageResult<AttachmentInfo> list(int pageNum, int pageSize, String searchVal) {
		return null;
	}
	
	/**
	 * 根据附件类型生成不同上传目录
	 * @param fileType
	 * @return
	 * @throws IOException 
	 */
	@Override
	public String generatedFilePath(AttachmentInfo record) throws IOException {
		int fileType = record.getFileType();
		String filePath = fileConfig.getUploadPath();
		if (FileType.IMG.getValue() == fileType) {
			filePath += "/" + fileConfig.getBaseImgDir() + "/" + record.getNewFilename();
		} else if (FileType.VIDEO.getValue() == fileType) {
			filePath += "/" + fileConfig.getBaseVideoDir();
		} else {
			filePath += "/" + fileConfig.getBaseDir();
		}
		return filePath;
	}
	
	/**
	 * 生成不同尺寸的缩略图
	 * @param sFile
	 * @param folder
	 * @param fileName
	 * @throws IOException
	 */
	private void generatedThumbnail(File sFile, File folder, String fileName, String ext) throws IOException {
		if (!folder.exists() || !folder.isDirectory()) {
			folder.mkdirs();
		}
		for (int size : iconSize) {
			File dfile = new File(folder, fileName + "_" + size + "." + ext);
			ImageUtils.zoom(sFile, dfile, size, size, ext);
		}
	}

}
