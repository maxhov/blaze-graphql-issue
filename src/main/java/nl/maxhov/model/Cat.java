/*
 * Copyright 2014 - 2024 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.maxhov.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cat {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private Integer age;
  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  private Cat mother;
  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  private Cat father;
  @ManyToMany
  private Set<Cat> kittens = new HashSet<>();

  public Cat() {
  }

  public Cat(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Cat getMother() {
    return mother;
  }

  public void setMother(Cat mother) {
    this.mother = mother;
  }

  public Cat getFather() {
    return father;
  }

  public void setFather(Cat father) {
    this.father = father;
  }

  public Set<Cat> getKittens() {
    return kittens;
  }

  public void setKittens(Set<Cat> kittens) {
    this.kittens = kittens;
  }
}