package com.upin.redis;

import com.upin.session.SessionDTO;

/**
 * @Created by Leslie on 2018/7/30.
 */
public interface SesssionManager {
    void buildSession(String token, SessionDTO session, Long timeoutHours);

    SessionDTO getSession(String token) throws Exception ;
}

