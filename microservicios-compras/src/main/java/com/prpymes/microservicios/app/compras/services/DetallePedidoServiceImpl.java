package com.prpymes.microservicios.app.compras.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.compras.models.entity.CompraSelectTotal;
import com.prpymes.microservicios.app.compras.models.entity.DetallePedido;
import com.prpymes.microservicios.app.compras.models.repository.DetallePedidoRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImplC;

@Service
public class DetallePedidoServiceImpl extends CommonServiceImplC<DetallePedido, DetallePedidoRepository> implements DetallePedidoService {

    @Override
    @Transactional(readOnly = true)
    public List<CompraSelectTotal> findByDateTotal(@Param("from") String from,@Param("to") String to) {
        return repository.findByDateTotal(from, to);
    }

    

}
