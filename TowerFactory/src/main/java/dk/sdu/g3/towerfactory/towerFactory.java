/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.towerfactory;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.common.services.ITowerFactory;
import dk.sdu.g3.tower.Tower;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 */
@ServiceProviders(value = {
    @ServiceProvider(service = ITowerFactory.class),})
public class towerFactory implements ITowerFactory  {
    
    @Override
    public ITower getNewTower() {
        return (ITower) new Tower();
    }

    @Override
    public ITower getNewTower(int life, int damage, int footprint, int cost, int attackSpeed, int attackRange, Coordinate position) {
        return (ITower) new Tower(life, damage, footprint, cost, attackSpeed, attackRange, position);
    }

}
