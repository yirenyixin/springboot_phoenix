package net.educoder.service;

import net.educoder.entity.JsMind;

import java.util.List;

public interface Step2Service {
    List<JsMind> findEventLogByCode(String id);
}
