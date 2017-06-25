package org.khcl.shopstops.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames={"name"}))
@Data
public class Shop{
@Id
@GeneratedValue
 private Long id;
 private String name;
 @Embedded
 private Address address;
 
 @Embedded
 private Location location;
 
}
