package demoProject.web.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

>>>>>>> develop
import org.springframework.web.multipart.MultipartFile;
import org.apache.log4j.Logger;

import org.apache.commons.io.IOUtils;
<<<<<<< HEAD
=======
import org.apache.commons.lang.StringUtils;
>>>>>>> develop

import java.io.StringWriter;
import java.nio.charset.Charset;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import demoProject.web.services.database.MongoDbService;

/**
<<<<<<< HEAD
 * Created by pythondev on 6/18/17.
=======
 * Created by jeff p on 6/18/17.
>>>>>>> develop
 */

@RequestMapping(value = "/doc/services")
@RestController
@Api( consumes = "JSON", produces = "JSON", value = "tweetStore", description = "Example of a web services which stores and fetches tweets from MongoDb ")
public class DocumentMngtServices {

    private static Logger LOG = Logger.getLogger(DocumentMngtServices.class);

    @Autowired
    private MongoDbService mongoDbService;

    @ApiOperation( value = "Saves a Tweet in MongoDb ", consumes = "application/json")
<<<<<<< HEAD
    @RequestMapping(method = RequestMethod.POST)
    public String storeDocument (@RequestParam("file") MultipartFile document ) {
=======
    @ApiResponses ( value = {
            @ApiResponse( code = 200, message = "Tweet was saved"),
            @ApiResponse( code = 500, message = "mongodb connection issue")
    })
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody String storeDocument (@RequestParam("file") MultipartFile document ) throws Exception {
>>>>>>> develop

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
<<<<<<< HEAD
        }

        return ""; //ADD ERROR CODE
=======
            throw e;
        }
>>>>>>> develop
    }

    @ApiOperation( value = "Fetches a specific tweet ", produces = "application/json")
    @ApiResponses ( value = {
<<<<<<< HEAD
        @ApiResponse( code = 200, message = "Save was Successful"),
        @ApiResponse( code = 404, message = "Tweet not found")
    })
    @RequestMapping(value = "fetch/{id}", method = RequestMethod.GET)
    public String getDocument ( @PathVariable("id") int docID) {
        LOG.info("REALLY COOL");
        return "DOC";
=======
            @ApiResponse( code = 200, message = "Successful"),
            @ApiResponse( code = 204, message = "Tweet not found"),
            @ApiResponse( code = 500, message = "mongodb connection issue")
    })
    @RequestMapping(value = "fetch/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getDocument (@PathVariable("id") String docID) {

        String tweet = mongoDbService.getDocument(docID);

        if (StringUtils.isNotBlank(tweet)) {
            BodyBuilder bodyBuilder = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON);
            return bodyBuilder.body(tweet);
        }

        return ResponseEntity.noContent().build();

>>>>>>> develop
    }

}
