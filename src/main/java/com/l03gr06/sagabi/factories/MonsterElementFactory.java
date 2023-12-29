package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.model.battlers.MonsterElement;

import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface MonsterElementFactory {
    public MonsterElement getElement(String element);
    public List<MonsterElement> getAllElements();
}
