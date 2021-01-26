package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.FeedbackMapper;
import com.liyang.orchard.model.Feedback;
import com.liyang.orchard.service.FeedbackService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class FeedbackServiceImpl extends AbstractService<Feedback> implements FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;

}
