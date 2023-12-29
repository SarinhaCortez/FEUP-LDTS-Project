package com.l03gr06.sagabi.viewer.map.interactable;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.viewer.map.MapViewer;
import com.l03gr06.sagabi.model.map.entities.interactables.*;

@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class InteractableTypeBasedViewer {
    public abstract void draw(GUI gui, Interactable interactable);
    public abstract boolean accepts(Interactable interactable);
}
