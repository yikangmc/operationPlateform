package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.entity.Taglib;


public interface FormPostsDao {
    int deleteByPrimaryKey(Long forumPostId);

    int insert(FormPosts record);

    int insertSelective(FormPosts record);

    FormPosts selectByPrimaryKey(Long forumPostId);

    int updateByPrimaryKeySelective(FormPosts record);

    int updateByPrimaryKey(FormPosts record);
    
    
    /**
     * @author liushuaic
     * @date 2016-04-27 11:11
     * @desc 获取推荐文章
     * **/
    List<FormPosts> getIsEssence(Map<String,Object> paramMap);
    
    /**
     * @author liushuaic
     * @desc 获取文章详情
     * forumPostId
     * userId
     * **/
    FormPosts getFormPoustsDetailByForumPostId(Map<String,Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-05 17:53
     * 文章支持+1
     * */
    void formPostsStarsUpByForumPostId(Long forumPostId);
    
    /**
     * @author liushuaic
     * @date 2016-05-05 17:53
     * 文章支持-1
     * */
    void formPostsStarsDownByForumPostId(Long forumPostId);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-12 18:00
     * @desc 获取某一个标签下的文章。
     * @param taglibId
     * @param userId
     * */
    List<FormPosts> getForumPostsByTaglibsId(Map<String,Object> paramMap);
    
    /**
     * 
     * @author liushuaic
     * @date 2016-05-31 14:10
     * @desc 获取某一个用户的最新发的文章
     * */
    List<FormPosts> getUserNewForumPostByCreateUserId(Long createUserId);
    
    /**
     * @author liushuaic
     * @date 2016-06-07 10:41
     * @desc 获取文章列表根据某一个用户的id
     * */
    List<FormPosts> geForumPostsByCreateUserId(Long createUserId);
    
    
    /**
     * @author liushuaic
     * @date 2016-06-06 19:18
     * @desc 获取最热帖子
     * **/
    List<FormPosts> getHotForumPosts();
    
    
    /**
     * @author liushuaic
     * @date 2016-06-07 11:02
     * @desc 获取某一个用户创建的文章
     * */
    List<FormPosts> geForumPostsByCreateUserId();
    
    /**
     * @author zxh
     *  @date 2016-07-06 14:06
     * @desc 获取帖子列表（按照更新时间倒序）
     */
    public List<FormPosts> getAllArticleListByPage(Map<String,Object> paramMap);
    
    /**
     * @author zxh
     *  @date 2016-07-06 18:06
     * @desc 保存帖子
     */
    public void saveTzContent();
    
    /**
     * 获取所有的专业文章列表
     * @return
     */
    public List<FormPosts> getAllProfessionListByPage();
    
    /**
     * 获取文章的详情
     * @param forumPostsId
     * @return
     */
    public FormPosts queryFormPostsInfo(Long forumPostsId);
    
    /**
     * 获取文章关联的标签
     * @param forumPostsId
     * @return
     */
    public List<Long> queryFormPostsTaglibsByFormPostsId(Long forumPostsId);
    
}