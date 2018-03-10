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
import javax.persistence.OneToMany
import javax.persistence.CascadeType

/**
 *
 * @author James Jones
 */
@Entity
class Groovy extends Rule {
	private String rule = ""
  @OneToMany(
    // mappedBy="groovy"
    cascade=CascadeType.ALL
  )
  private Set<Link> links
  public String getRule() {
    return this.rule
  }
  public void setRule(String rule) {
    this.rule = rule
  }
  public Set<Link> getLinks() {
    return this.links
  }
  public void setLinks(Set<Link> links) {
    this.links = links
  }

}

