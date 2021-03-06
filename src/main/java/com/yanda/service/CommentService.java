package com.yanda.service;

import com.yanda.entity.PageResult;
import com.yanda.entity.generated.CommentInfo;
import com.yanda.exception.DOPException;

public interface CommentService extends BaseService<CommentInfo, Long> {

	/**
	 * 根据视频id获取对应的评论列表
	 * @param pageNum
	 * @param pageSize
	 * @param episodeId	视频Id
	 * @param parentId 父评论Id, 默认值为0, 表示直接加载视频下方的评论
	 * @param criteria 评论展示的排序条件,暂时允许3种情况 '2'代表默认排序(时间顺序) '1'代表最新发表 '3'代表根据点赞数排序
	 * @return
	 */
	PageResult<CommentInfo> list(int pageNum, int pageSize, Long episodeId, Long parentId, String criteria);
	
	
	/**
	 * 评论点赞或取消点赞
	 * @param commentId
	 * @param userId
	 * @throws DOPException 
	 */
	void toggleAgreeCount(Long commentId, Long episodeId, Long userId) throws DOPException;
	
	/**
	 * 保存评论
	 * @param commentInfo
	 * @throws DOPException 
	 */
	void saveComment(CommentInfo commentInfo) throws DOPException;
}
