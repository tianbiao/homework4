package org.nightschool.Controller;

/**
 * Created by Administrator on 2014/12/20.
 */

import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.nightschool.model.Disk;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeFunction.function;

@Path("/disks")
public class DiskController {


    private final ArrayList<Disk>  disks = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Disk> list() {  return disks;
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Disk add(Disk disk) {
        disks.add(disk);
        return disk;
    }

    @POST
    @Path("remove")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Disk remove(Disk disk) {
        int num=0;
        for(int i=0;i<disks.size();i++) {
            if (disks.get(i).getName().equals(disk.getName()))
                num=i;
        }
        disks.remove(num);
        return disk;
    }
}
