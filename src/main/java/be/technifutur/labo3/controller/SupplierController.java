package be.technifutur.labo3.controller;

import be.technifutur.labo3.dto.SupplierDTO;
import be.technifutur.labo3.entity.Supplier;
import be.technifutur.labo3.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/suppliers")
public class SupplierController implements RestControllable<Supplier, SupplierDTO, Integer> {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<List<SupplierDTO>> getAll() {
        return ResponseEntity.ok(this.supplierService.getAll());
    }

    @Override
    @GetMapping (path = "/{id}")
    public ResponseEntity<SupplierDTO> getOne(@PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.supplierService.getById(integer));
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<Boolean> insert(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(this.supplierService.insert(supplier));
    }

    @Override
    @PutMapping (path = "/{id}" )
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<Boolean> update(@RequestBody Supplier supplier, @PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.supplierService.update(supplier,integer));
    }

    @Override
    @DeleteMapping (path = "/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer integer) {
        return ResponseEntity.ok(this.supplierService.delete(integer));
    }


}
