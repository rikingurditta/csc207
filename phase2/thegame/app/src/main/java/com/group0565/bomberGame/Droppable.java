package com.group0565.bomberGame;

import com.group0565.engine.interfaces.Canvas;
import com.group0565.engine.render.ThemedPaintCan;
import com.group0565.math.Coords;
import com.group0565.math.Vector;

public class Droppable extends GridObject {
    /** The game this Crate belongs to. */
    private BomberEngine game;

    /** PaintCan for this crate's fill. */
    private ThemedPaintCan paintCan = new ThemedPaintCan("Bomber", "Droppable.Droppable");

    /**
     * Constructs a new Crate.
     *
     * @param position The position of this object on the grid.
     * @param z The z-level of the object.
     * @param game The game this crate belongs to.
     * @param grid The grid this crate is within.
     */
    public Droppable(Coords position, double z, SquareGrid grid, BomberEngine game) {
        super(position, z, grid);
        this.game = game;
        this.grid.addItem(this, position);
    }

    /**
     * Constructs a new Crate.
     *
     * @param position The position of this object on the grid.
     * @param game The game this crate belongs to.
     * @param grid The grid this crate is within.
     */
    public Droppable(Coords position, SquareGrid grid, BomberEngine  game) {
        this(position, 0, grid, game);
    }

    @Override
    public void init() {
        super.init();
        paintCan.init(getGlobalPreferences(), getEngine().getGameAssetManager());
    }

    /** Destroy this crate if the damage done to it is positive. */
    @Override
    public void damage(int d) {

        if (d > 0) {
            grid.remove(this);
            game.removeLater(this);
        }
    }

    @Override
    public boolean isBomb() {
        return false;
    }

    @Override
    public boolean isDroppable() {
        return true;
    }

    /**
     * Draws ONLY this object to canvas. Its children are not drawn by this method.
     *
     * @param canvas The Canvas on which to draw this crate.
     */
    @Override
    public void draw(Canvas canvas) {
        Vector pos = getAbsolutePosition();
        // Draw a rectangle at our touch position
        canvas.drawRect(pos, new Vector(grid.getTileWidth(), grid.getTileWidth()), paintCan);
    }
}
