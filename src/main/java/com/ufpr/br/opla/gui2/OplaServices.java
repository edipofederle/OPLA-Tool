/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ufpr.br.opla.gui2;

import arquitetura.builders.ArchitectureBuilder;
import arquitetura.representation.Architecture;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.GenerateArchitecture;

/**
 *
 * @author elf
 */
public class OplaServices {

    private ManagerApplicationConfig  config;
    OplaServices(ManagerApplicationConfig c) {
        config = c;
    }

    void run() {
        ArchitectureBuilder builder = new ArchitectureBuilder();
        try {
            Architecture a = builder.create(VolatileConfs.getArchitectureInputPath());
            GenerateArchitecture generate = new GenerateArchitecture();
            generate.generate(a, "teste1");
        } catch (Exception ex) {
            Logger.getLogger(OplaServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}