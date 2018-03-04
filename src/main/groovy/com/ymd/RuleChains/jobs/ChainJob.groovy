/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ymd.RuleChains.jobs

import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException
import org.springframework.scheduling.quartz.QuartzJobBean

/**
 *
 * @author james
 */
class ChainJob extends QuartzJobBean {
    /**
     * The base execution method which extracts the chain name and executes it
     * 
     * @param   context    The quartz scheduler context for the scheduled job
     */
    void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // execute job
        def chain = Chain.findByName(context.mergedJobDataMap.get('name'))
        def input = Chain.findByName(context.mergedJobDataMap.get('input'))
        //println context.mergedJobDataMap.get('name')
        if(!!chain) {
            chain.execute((!!input)?input:[[:]])
        }
    }

}

