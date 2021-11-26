package com.cursoselenium.library.configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Unmarshaler {

    public Configuration unmarshal() throws JAXBException {
        File file = new File("configFile.xml");
        JAXBContext context = JAXBContext.newInstance(Configuration.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Configuration)unmarshaller.unmarshal(file);
    }
}
