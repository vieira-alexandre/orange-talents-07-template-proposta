package br.com.zupacademy.propostas.apiclients.cartoes;

import br.com.zupacademy.propostas.controllers.dto.request.NovaCarteiraRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(value = "cartaoClient",url = "${values.consulta-cartao-url}")
public interface CartaoClient {
    @GetMapping(value = "/cartoes")
    CartaoResponse consultaCartao(@RequestParam String idProposta);

    @PostMapping(value = "/cartoes/{id}/bloqueios")
    ResultadoResponse solicitaBloqueio(@PathVariable String id, @RequestBody BloqueioRequest request);

    @PostMapping(value = "/cartoes/{id}/avisos")
    ResultadoResponse enviaAviso(@PathVariable String id, @RequestBody @Valid AvisoRequest request);

    @PostMapping(value = "/cartoes/{id}/carteiras")
    ResultadoResponse associaCarteira(@PathVariable String id, @RequestBody @Valid NovaCarteiraRequest request);
}
