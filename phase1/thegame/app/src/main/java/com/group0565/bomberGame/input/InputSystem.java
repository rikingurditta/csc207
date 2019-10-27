package com.group0565.bomberGame.input;

import com.group0565.engine.gameobjects.GameObject;
import com.group0565.math.Vector;

/**
 * Abstract class for InputSystems, objects that process input to control a player.
 */
public abstract class InputSystem extends GameObject {
    /**
     * The BomberInput object that will be managed by this InputSystem.
     */
    BomberInput input = new BomberInput();

    /**
     * Constructs a new InputSystem.
     * @param position      The position (relative or absolute) of this object.
     * @param z             The z-level of the object.
     */
    InputSystem(Vector position, double z) {
        super(position, z);
    }

    /**
     * Constructs a new InputSystem.
     * @param position      The position (relative or absolute) of this object.
     */
    InputSystem(Vector position) {
        super(position);
    }

    /**
     * Setter for this InputSystem's BomberInput object.
     */
    public void setInput(BomberInput input) {
        this.input = input;
    }

    /**
     * Getter for this InputSystem's BomberInput object.
     */
    public BomberInput getInput() {
        return input;
    }
}
