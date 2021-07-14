package com.agent.dcms.repappoinment;

import com.agent.dcms.service.repappoinment.RepAppoinmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * {@code RepAppoinmentController} contains all the repappoinment function to perform various operations on DCMS
 *
 * @author Thamizh
 */
public class RepAppoinmentController {
//    private static final Logger LOGGER = LoggerFactory.getLogger(RepAppoinmentController.class);

    @Autowired
    public RepAppoinmentService repoAppoinmentService;

}
