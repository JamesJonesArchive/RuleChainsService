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
  private long id
  
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
  private Chain chain
}

