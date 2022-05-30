package es.vetappoint.controllers;

import es.vetappoint.config.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;


    /**
     * @return  Ir a la página de carga de archivos
     */
    @RequestMapping("/Demo")
    public String index(){
        return "Dome";
    }
    /**
     *
     * @return  Ir a la página de visualización de archivos
     */
    @RequestMapping("/show")
    public String show(){
        return "show";
    }
    /**
     *
     * @param  archivo subido
     * @return
     */
    @ResponseBody
    @RequestMapping("/fileUpload")
    public String upload(@RequestParam("file") MultipartFile file ){
        // 1 define la ruta de almacenamiento del archivo que se va a cargar
        String localPath="D:/image";
        // 2 obtener el nombre del archivo
        String fileName=file.getOriginalFilename();
        // 2 mensajes de error de carga
        String warning="";
        if(FileUtils.upload(file, localPath, fileName)){
            // Carga exitosa
            warning="Carga exitosa";

        }else{
            warning="Error al subir";
        }
        System.out.println(warning);
        return "Carga exitosa";
    }

    /**
     * Mostrar imagen
     * @param  fileName nombre de archivo
     * @return
     */

    @RequestMapping("/showFile")
    public ResponseEntity show(String fileName){


        try {
            // Debido a que está leyendo el archivo local, se debe agregar el archivo, la ruta es la ruta en el archivo de configuración de la aplicación
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
