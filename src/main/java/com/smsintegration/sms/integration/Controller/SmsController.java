package com.smsintegration.sms.integration.Controller;

import com.smsintegration.sms.integration.Payload.MessageRequest;
import com.smsintegration.sms.integration.Service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class SmsController {



    private final TwilioService twilioService;
@Autowired
    public SmsController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping("/send")
    public String sendSms(@RequestBody MessageRequest smsRequest) {
        twilioService.sendSms(smsRequest.getTo(), smsRequest.getMessage());
        return "SMS sent successfully";
    }
}
