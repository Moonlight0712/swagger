package com.lay.swagger.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dragon code!
 * @create 2022-08-24 23:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户实体类",description = "用户从客户端传入的数据的封装")
public class User {
  @ApiModelProperty("姓名")
  String name;
  @ApiModelProperty(value = "年龄",example = "1")
  Integer age;
  @TableId(value="id",type = IdType.AUTO)
  @ApiModelProperty(value = "主键id",example = "1")
  Integer id;
  //字段添加填充内容
  @TableField(fill = FieldFill.INSERT)
  @ApiModelProperty("创建时间")
  private Date createTime;
  //https://blog.csdn.net/weixin_46369022/article/details/124081121
  //https://blog.csdn.net/qq_43842093/article/details/124956549
  @TableField(fill = FieldFill.INSERT_UPDATE)
  @ApiModelProperty("修改时间")
  private Date updateTime;
  @Version
  //https://blog.csdn.net/qq122516902/article/details/89673363
  @ApiModelProperty(value = "版本，用于乐观锁",example = "1")
  Integer version;
  //逻辑删除字段
  @TableLogic
  @ApiModelProperty(value = "逻辑删除字段",example = "1")
  private Integer deleted;


  public User(Integer id,String name) {
    this.name = name;
    this.id = id;
  }
}
