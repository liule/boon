package org.boon.di;

import org.boon.Maps;

import java.util.Map;

/**
 * Created by Richard on 2/4/14.
 */
public class Creator {

    public static <T> T create(Class<T> type, Map<?, ?> map) {
      Context context = DependencyInjection.fromMap(map);
      context.add( DependencyInjection.classes(type) );
      return context.get( type );
    }


    public static <T> T create(Class<T> type, Context context) {
        context.add( DependencyInjection.classes(type) );
        return context.get( type );
    }


    public static <T> T newOf( Class<T> type, Object... args ) {
        Map<?, ?> map = Maps.mapFromArray( args );
        Context context = DependencyInjection.fromMap(map);
        context.add( DependencyInjection.classes(type) );
        return context.get( type );
    }  
}
