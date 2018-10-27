/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.it.testcase;

import org.apache.servicecomb.it.extend.engine.ITSCBRestTemplate;
import org.junit.Assert;
import org.junit.Test;

public class TestRestController {
  private static ITSCBRestTemplate restControllerSchemaClient = new ITSCBRestTemplate
      ("org.apache.servicecomb.it.schema.RestControllerSchema");

  private static ITSCBRestTemplate restControllerEmptyMappingSchemaClient = new ITSCBRestTemplate
      ("org.apache.servicecomb.it.schema.RestControllerEmptyMappingSchema");

  private static ITSCBRestTemplate restControllerWithRequestMappingSchemaClient = new ITSCBRestTemplate
      ("org.apache.servicecomb.it.schema.RestControllerWithRequestMappingSchema");

  private static ITSCBRestTemplate restControllerWithRestSchemaSchemaClient = new ITSCBRestTemplate
      ("RestControllerWithRestSchemaSchema");

  @Test
  public void restControllerSchemaClient() {
    Assert.assertEquals("/", restControllerSchemaClient.getBasePath());
    int result = restControllerSchemaClient.getForObject("/restControllerSchemaQuery?input=2", int.class);
    Assert.assertEquals(2, result);
  }

  @Test
  public void restControllerEmptyMappingSchemaClient() {
    // empty path default to class name(@RequestMapping(path = "")). Shall we change this behavior in future?
    Assert.assertEquals("/RestControllerEmptyMappingSchema", restControllerEmptyMappingSchemaClient.getBasePath());
    int result = restControllerEmptyMappingSchemaClient
        .getForObject("/restControllerEmptyMappingSchemaQuery?input=2", int.class);
    Assert.assertEquals(2, result);
  }

  @Test
  public void restControllerWithRequestMappingSchemaClient() {
    Assert.assertEquals("/restControllerWithRequest", restControllerWithRequestMappingSchemaClient.getBasePath());
    int result = restControllerWithRequestMappingSchemaClient
        .getForObject("/restControllerWithRequestMappingSchemaQuery?input=2", int.class);
    Assert.assertEquals(2, result);
  }

  @Test
  public void restControllerWithRestSchemaSchemaClient() {
    Assert.assertEquals("/restControllerWithRestSchemaSchema", restControllerWithRestSchemaSchemaClient.getBasePath());
    int result = restControllerWithRestSchemaSchemaClient
        .getForObject("/restControllerWithRestSchemaSchemaQuery?input=2", int.class);
    Assert.assertEquals(2, result);
  }
}
