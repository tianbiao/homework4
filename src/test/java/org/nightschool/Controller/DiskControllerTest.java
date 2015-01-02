package org.nightschool.Controller;

import junit.framework.TestCase;
import org.junit.Test;
import org.nightschool.model.Disk;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiskControllerTest extends TestCase {

    private DiskController diskController  = new DiskController();

    @Test
    public void test_list_disks_is_empty() throws Exception {
        List<Disk> disks = diskController.list();
        assertThat(disks.size(),is(0));
    }

    @Test
    public void test_list_disks_is_non_empty_after_add_a_disk() throws Exception {
        Disk disk = new Disk("name","img","desc");
        diskController.add(disk);
        assertThat(diskController.list().size(),is(1));
    }

    @Test
    public void test_list_disks_is_empty_after_remove_a_disk() throws Exception {
        Disk disk = new Disk("name","img","desc");
        diskController.remove(disk);
        assertThat(diskController.list().size(),is(0));
    }

}