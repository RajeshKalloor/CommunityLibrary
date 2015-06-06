package com.hackday.bookmybook.bootstrap;

import com.hackday.bookmybook.Example.HelloResource;
import com.hackday.bookmybook.Example.PostResource;
import com.hackday.bookmybook.config.ServiceConfiguration;
//import com.hackday.internal.resources.GetAllProducts;
//import com.hackday.internal.resources.GetProduct;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.hackday.bookmybook.Example.UserResource;

/**
 * Created by sankeerth.reddy on 04/06/15.
 */
public class BootStrapper extends Service<ServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new BootStrapper().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        bootstrap.setName("dropwizard-example");
    }

    @Override
    public void run(ServiceConfiguration conf, Environment env) throws Exception {
        // we will add resource classes here
        //env.addResource(new HelloResource(conf.getMessages()));
        env.addResource(new UserResource());
        //env.addResource(new GetAllProducts());
        //env.addResource(new GetProduct());

    }

}
