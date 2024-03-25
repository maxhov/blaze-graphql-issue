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

@Entity
public class ColoredCat extends Cat {

  private String color;

  public ColoredCat(String name, Integer age, String color) {
    super(name, age);
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColour(String color) {
    this.color = color;
  }
}
