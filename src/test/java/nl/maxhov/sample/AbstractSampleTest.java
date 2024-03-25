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

package nl.maxhov.sample;

import jakarta.persistence.EntityManager;
import nl.maxhov.model.ColoredCat;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractSampleTest {

  @Autowired
  protected EntityManager em;

  @BeforeEach
  public void init() {
    var blackCat = new ColoredCat("Black Cat", 1, "Black");
    em.persist(blackCat);

    var whiteCat = new ColoredCat("White Cat", 2, "White");
    em.persist(whiteCat);

    var grayCat = new ColoredCat("Gray Cat", 3, "Gray");
    em.persist(grayCat);

    var brownCat = new ColoredCat("Brown Cat", 4, "Brown");
    em.persist(brownCat);
  }
}
