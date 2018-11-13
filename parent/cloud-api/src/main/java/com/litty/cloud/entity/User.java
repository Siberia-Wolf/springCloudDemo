package com.litty.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String sex;
    private Integer age;
    private String address;

    @Transient
    private String none;


}
