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

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
public class SampleTest extends AbstractSampleTest {

  @Autowired
  private GraphQlTester graphQlTester;

  @Test
  public void errors_on_cats() {
    graphQlTester.documentName("cats")
        .operationName("Cats")
        .execute()
        .errors();
  }

  @Test
  public void succeeds_on_colored_cats() {
    graphQlTester.documentName("coloredCats")
        .operationName("ColoredCats")
        .execute()
        .path("coloredCats").matchesJsonStrictly("""
              {
                "edges": [
                  {
                    "node": {
                      "name": "Black Cat",
                      "color": "Black"
                    }
                  },
                  {
                    "node": {
                      "name": "White Cat",
                      "color": "White"
                    }
                  },
                  {
                    "node": {
                      "name": "Gray Cat",
                      "color": "Gray"
                    }
                  },
                  {
                    "node": {
                      "name": "Brown Cat",
                      "color": "Brown"
                    }
                  }
                ]
              }
            }""");
  }
}
