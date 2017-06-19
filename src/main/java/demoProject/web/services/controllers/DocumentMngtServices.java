package demoProject.web.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.apache.log4j.Logger;

import org.apache.commons.io.IOUtils;

import java.io.StringWriter;
import java.nio.charset.Charset;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import demoProject.web.services.database.MongoDbService;

/**
 * Created by pythondev on 6/18/17.
 */

@RequestMapping(value = "/doc/services")
@RestController
@Api( consumes = "JSON", produces = "JSON", value = "tweetStore", description = "Example of a web services which stores and fetches tweets from MongoDb ")
public class DocumentMngtServices {

    private static Logger LOG = Logger.getLogger(DocumentMngtServices.class);

    @Autowired
    private MongoDbService mongoDbService;

    @ApiOperation( value = "Saves a Tweet in MongoDb ", consumes = "application/json")
    @RequestMapping(method = RequestMethod.POST)
    public String storeDocument (@RequestParam("file") MultipartFile document ) {

        try {
            StringWriter writer = new StringWriter();
            IOUtils.copy(document.getInputStream(), writer, Charset.defaultCharset());

            String json = writer.toString();
            String id = mongoDbService.saveDocument(json);

            LOG.info(json);

            return id;
        }
        catch (Exception e) {
            LOG.info(e.toString());
        }

        return ""; //ADD ERROR CODE
    }

    @ApiOperation( value = "Fetches a specific tweet ", produces = "application/json")
    @ApiResponses ( value = {
        @ApiResponse( code = 200, message = "Save was Successful"),
        @ApiResponse( code = 404, message = "Tweet not found")
    })
    @RequestMapping(value = "fetch/{id}", method = RequestMethod.GET)
    public String getDocument ( @PathVariable("id") int docID) {
        LOG.info("REALLY COOL");
        return "DOC";
    }

}
