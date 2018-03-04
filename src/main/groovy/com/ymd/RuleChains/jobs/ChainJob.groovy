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

package com.ymd.RuleChains.jobs

import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException
import org.springframework.scheduling.quartz.QuartzJobBean

/**
 *
 * @author James Jones
 */
class ChainJob extends QuartzJobBean {
    /**
     * The base execution method which extracts the chain name and executes it
     * 
     * @param   context    The quartz scheduler context for the scheduled job
     */
    void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // execute job
//        def chain = Chain.findByName(context.mergedJobDataMap.get('name'))
//        def input = Chain.findByName(context.mergedJobDataMap.get('input'))
//        //println context.mergedJobDataMap.get('name')
//        if(!!chain) {
//            chain.execute((!!input)?input:[[:]])
//        }
    }

}

