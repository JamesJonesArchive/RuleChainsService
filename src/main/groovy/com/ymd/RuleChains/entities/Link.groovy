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

package com.ymd.RuleChains.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.FetchType
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn

import com.ymd.RuleChains.enums.ExecuteEnum
import com.ymd.RuleChains.enums.ResultEnum
import com.ymd.RuleChains.enums.LinkEnum
/**
 *
 * @author James Jones
 */
@Entity
class Link {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id
  
  @Column(nullable = false)
  private int sequenceNumber
  private String inputReorder = ''
  private String outputReorder = ''
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private ExecuteEnum executeEnum = ExecuteEnum.NORMAL
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private ResultEnum resultEnum = ResultEnum.NONE
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private LinkEnum linkEnum = LinkEnum.NONE
  @ManyToOne(fetch=FetchType.LAZY)
  private Rule rule
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="chain_id")
  private Chain chain
  public Long getId() {
    return this.id
  }
  public void setId(Long id) {
    this.id = id
  }
  public int getSequenceNumber() {
    return this.sequenceNumber
  }
  public void setSequenceNumber(int sequenceNumber) {
    this.sequenceNumber = sequenceNumber
  }
  public String getInputReorder() {
    return this.inputReorder
  }
  public void setInputReorder(String inputReorder) {
    this.inputReorder = inputReorder
  }
  public String getOutputReorder() {
    return this.outputReorder
  }
  public void setOutputReorder(String outputReorder) {
    this.outputReorder = outputReorder
  }
  public ExecuteEnum getExecuteEnum() {
    return this.executeEnum
  }
  public void setExecuteEnum(ExecuteEnum executeEnum) {
    this.executeEnum = executeEnum
  }
  public ResultEnum getResultEnum() {
    return this.resultEnum
  }
  public void setResultEnum(ResultEnum resultEnum) {
    this.resultEnum = resultEnum
  }
  public LinkEnum getLinkEnum() {
    return this.linkEnum
  }
  public void setLinkEnum(LinkEnum linkEnum) {
    this.linkEnum = linkEnum
  }
  public Rule getRule() {
    return this.rule
  }
  public void setRule(Rule rule) {
    this.rule = rule
  }
  public Chain getChain() {
    return this.chain
  }
  public void setChain(Chain chain) {
    this.chain = chain
  }
}

