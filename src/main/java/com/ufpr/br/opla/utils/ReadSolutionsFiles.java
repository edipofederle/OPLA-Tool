/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.br.opla.utils;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author elf
 */
public class ReadSolutionsFiles {

  public static List<File> read(String experimentId, String executionId,
          String pathToOutput) {

    String exts[] = {"uml"};
    StringBuilder path = new StringBuilder();
    path.append(pathToOutput);
    path.append(experimentId);
    path.append("/");
    path.append(executionId);
    path.append("/");

    StringBuilder pathAll = new StringBuilder();
    pathAll.append(pathToOutput);
    pathAll.append(experimentId);
    pathAll.append("/");

    List<File> files = (List<File>) FileUtils.listFiles(
            new File(path.toString()),
            exts, false);

    List<File> filesAll = (List<File>) FileUtils.listFiles(
            new File(pathAll.toString()),
            exts, false);

    files.addAll(filesAll);
    return files;

  }

  public static int countNumberNonDominatedSolutins(String experimentId, String pathToOutput) {

    String exts[] = {"uml"};
  

    StringBuilder pathAll = new StringBuilder();
    pathAll.append(pathToOutput);
    pathAll.append(experimentId);
    pathAll.append("/");


    List<File> files = (List<File>) FileUtils.listFiles(
            new File(pathAll.toString()),
            exts, false);

    
    return files.size();

  }
}