package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.ReportMapper;
import com.liyang.orchard.model.Report;
import com.liyang.orchard.service.ReportService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class ReportServiceImpl extends AbstractService<Report> implements ReportService {
    @Resource
    private ReportMapper reportMapper;

}
