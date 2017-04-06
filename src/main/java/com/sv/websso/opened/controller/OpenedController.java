package com.sv.websso.opened.controller;

import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.saml2.metadata.provider.HTTPMetadataProvider;
import org.opensaml.saml2.metadata.provider.MetadataProviderException;
import org.opensaml.xml.parse.StaticBasicParserPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.saml.metadata.CachingMetadataManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OpenedController {

    @Autowired
    private CachingMetadataManager metadata;

    @Autowired
    private StaticBasicParserPool parserPool;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("init");
    }

    @RequestMapping(value = "/redirectToWebSSO", method = RequestMethod.GET)
    public ModelAndView redirectToAuth(@RequestParam(value = "metadataURL") String metadataURL) throws MetadataProviderException {
        HTTPMetadataProvider provider = new HTTPMetadataProvider(metadataURL, 500);
        provider.setParserPool(parserPool);
        provider.initialize();
        String newIDP;
        if (provider.getMetadata() instanceof EntityDescriptor) {
            EntityDescriptor entityDescriptor =  (EntityDescriptor)provider.getMetadata();
            newIDP = entityDescriptor.getEntityID();
        } else {
            throw new RuntimeException("Solve multiple EntityIDs");
        }

        if (/*metadata.getExtendedMetadata(newIDP) == null*/1==1) { // leads to duplication of metadata providers
            metadata.addMetadataProvider(provider);
            metadata.refreshMetadata();
        }

        return new ModelAndView("redirect:/saml/login?idp="+newIDP);
    }

}