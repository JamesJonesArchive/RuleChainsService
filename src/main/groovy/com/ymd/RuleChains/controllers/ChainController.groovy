/*
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


package com.ymd.RuleChains.controllers

import com.ymd.RuleChains.entities.Chain
import com.ymd.RuleChains.services.ChainService
import com.ymd.RuleChains.repositories.ChainRepository
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.multipart.MultipartFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.MediaType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
/**
 *
 * @author James Jones
 */
@RestController
@RequestMapping(value = "/api/chain")
class ChainController {
  @Autowired
  private ChainRepository chainRepository

  @Autowired
  private ChainService chainService

  @RequestMapping(
    value = "/{name}",
    method = RequestMethod.GET,
    // consumes = {"application/json", "application/xml"},
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody Chain getChain(@PathVariable("name") String name,
      HttpServletRequest request, HttpServletResponse response) throws Exception {
    // Chain chain = chainRepository.findByName(name);
    // return chainRepository.findByName(name);
    // Chain chain = chainService.getChainByName(name)
    return chainService.getChainByName(name)
  }
  @RequestMapping(
    value = "/",
    method = RequestMethod.GET,
    // consumes = {"application/json", "application/xml"},
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody Chain listChains(@RequestParam Map<String, String> queryParameters,
      HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(queryParameters.containsKey("pattern")) {
      return chainService.listChains(queryParameters.get("pattern"))
    } else {
      return chainService.listChains()
    }
  }

}

