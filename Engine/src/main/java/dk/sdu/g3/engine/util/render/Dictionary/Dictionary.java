/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.engine.util.render.Dictionary;

import dk.sdu.g3.common.data.inputMapping;
import dk.sdu.g3.common.data.Coordinate;
import java.util.ArrayList;
import java.util.List;

public class Dictionary implements Dict {

    List<inputMapping> mappings = new ArrayList<inputMapping>();

    /**
     *
     * @param center Coordinate of the center point of an square element
     * @param tileSize the "radius" of an tile
     * @param footPrint how many tiles this elemet takes up
     * @param refrence
     */
    @Override
    public void insert(Coordinate center, int tileSize, int footPrint, Object refrence) {
        inputMapping element = new inputMapping(center, tileSize, footPrint, refrence);
        mappings.add(element);

    }

    /**
     * removes an object
     *
     * @param refrence to the object that should be removed
     */
    @Override
    public void remove(Object refrence) {
        for (inputMapping m : mappings) {
            if (m.getRefrence().equals(refrence)) {
                mappings.remove(m);
                break;
            }
        }
    }

    /**
     * finds what object the coordinate is within
     *
     * @param target the coordinates of the clicked point
     * @return the reference to the object hit
     */
    @Override
    public Object search(Coordinate target) {
        for (inputMapping m : mappings) {
            if (!(m.getOrigoX() <= target.getX() && target.getX() <= m.getBorderX())) {

                continue;
            }

            if (m.getOrigoY() <= target.getY() && target.getY() <= m.getBorderY()) {

                return m.getReference();
            }
        }
        return null;
    }

   

}