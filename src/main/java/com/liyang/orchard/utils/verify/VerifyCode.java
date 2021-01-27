package com.liyang.orchard.utils.verify;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerifyCode {
    private String code;
    private byte[] imgBytes;
    private long expireTime;

}
