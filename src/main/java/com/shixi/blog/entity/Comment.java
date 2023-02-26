package com.shixi.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author group
 * @since 2023-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Comment对象", description="评论表")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "文章id")
    private Long articleId;

    @ApiModelProperty(value = "父评论id，如果为空则表示该评论是一级评论")
    private Long parentId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "评论人用户名")
    private String username;

    @ApiModelProperty(value = "评论创建时间")
    private Date createTime;

    @ApiModelProperty(value = "是否显示")
    private Boolean isShow;

}
