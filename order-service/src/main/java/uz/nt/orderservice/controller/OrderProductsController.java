package uz.nt.orderservice.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import shared.libs.dto.ResponseDto;
import uz.nt.orderservice.dto.OrderProductsDto;
import uz.nt.orderservice.service.OrderProductsService;

import java.lang.reflect.Method;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orderProducts")
public class OrderProductsController {
    private final OrderProductsService orderProductsService;

    @GetMapping("/byPage")
    public ResponseDto<Page<OrderProductsDto>> getAllOrderProductsByPage(@RequestParam Integer page,
                                                          @RequestParam Integer size) throws NoSuchMethodException {
        ResponseDto<Page<OrderProductsDto>> responseDto = orderProductsService
                .getAllOrderProductsByPage(page, size);
        Method method = OrderProductsController.class.getMethod(
                "getAllOrderProductsByPage", Integer.class, Integer.class);

        return orderProductsService.responseDtoWithLink(page, size, method, responseDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<OrderProductsDto> getById(@PathVariable Integer id){
        return orderProductsService.getById(id);
    }
}
