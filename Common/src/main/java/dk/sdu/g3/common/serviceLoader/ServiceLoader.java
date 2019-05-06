/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.serviceLoader;

import java.util.ArrayList;
import java.util.Collection;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

/**
 *
 * @author sebastian
 */
public class ServiceLoader {
        ArrayList<Object> ServiceProviderList = new ArrayList();
        Class IService;

        private final Lookup lookup = Lookup.getDefault();
        private Lookup.Result<Class> result;

        public ServiceLoader(Class IService) {
            //vars
            this.IService = IService;
            result = lookup.lookupResult(IService); //Finds SP'
            result.addLookupListener(lookupListener);
            result.allItems();

            System.out.println("---IGamePluginService---");
            //inizial load
            for (Object plugin : result.allInstances()) {
                System.out.println(plugin);
                ServiceProviderList.add(plugin);
            }
        }

        private final LookupListener lookupListener = new LookupListener() {
            @Override
            public void resultChanged(LookupEvent le) {

                Collection<? extends Class> updated = result.allInstances();

                for (Object us : updated) {
                    // Newly installed modules
                    if (!ServiceProviderList.contains(us)) {
                        ServiceProviderList.add(us);
                    }
                }

                // Stop and remove module
                for (Object gs : ServiceProviderList) {
                    if (!updated.contains(gs)) {

                        ServiceProviderList.remove(gs);
                    }
                }
            }
        };

        private <Å> Collection<? extends Å> getSP(Class<Å> SPI) {
            return lookup.lookupAll(SPI);
        }
    public ArrayList<?> getServiceProviderList() {
        return ServiceProviderList;
    }

    }