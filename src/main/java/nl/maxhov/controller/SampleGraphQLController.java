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

package nl.maxhov.controller;

import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.integration.graphql.GraphQLRelayConnection;
import graphql.schema.DataFetchingEnvironment;
import nl.maxhov.repository.CatViewRepository;
import nl.maxhov.view.CatView;
import nl.maxhov.view.ColoredCatView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SampleGraphQLController {

  @Autowired
  CatViewRepository catRepo;

  @Autowired
  GraphQLEntityViewSupport entityViewSupport;

  @QueryMapping
  public GraphQLRelayConnection<CatView> cats(
      DataFetchingEnvironment dataFetchingEnvironment) {
    var setting =
        entityViewSupport.createPaginatedSetting(CatView.class, dataFetchingEnvironment);
    return new GraphQLRelayConnection<>(catRepo.findAll(setting));
  }

  @QueryMapping
  public GraphQLRelayConnection<ColoredCatView> coloredCats(
      DataFetchingEnvironment dataFetchingEnvironment) {
    var setting =
        entityViewSupport.createPaginatedSetting(ColoredCatView.class, dataFetchingEnvironment);
    return new GraphQLRelayConnection<>(catRepo.findAll(setting));
  }
}