package br.com.cotiinformatica.configurations;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cotiinformatica.dto.TarefaRequest;
import br.com.cotiinformatica.dto.TarefaResponse;
import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.entities.Tarefa;

@Configuration
public class ModelMapperConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();

    mapper.addMappings(new PropertyMap<TarefaRequest, Tarefa>() {

      @Override
      protected void configure() {
        // Mapear título e finalizado automaticamente
        map().setTitulo(source.getTitulo());
        map().setFinalizado(source.isFinalizado());

        // Converter data + hora em Date
        using(ctx -> {
          try {
            String data = ((TarefaRequest) ctx.getSource()).getData();
            String hora = ((TarefaRequest) ctx.getSource()).getHora();
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(data + " " + hora);
          } catch (Exception e) {
            return null;
          }
        }).map(source, destination.getDataHora());

        // Montar Categoria a partir do ID
        using(ctx -> {
          Categoria categoria = new Categoria();
          categoria.setId(((TarefaRequest) ctx.getSource()).getCategoriaId());
          return categoria;
        }).map(source, destination.getCategoria());
      }
    });

    mapper.addMappings(new PropertyMap<Tarefa, TarefaResponse>() {

      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setTitulo(source.getTitulo());
        map().setFinalizado(source.getFinalizado());

        using(ctx -> {
          Date dataHora = (Date) ctx.getSource();
          if (dataHora == null)
            return null;
          return new java.text.SimpleDateFormat("yyyy-MM-dd").format(dataHora);
        }).map(source.getDataHora(), destination.getData());

        using(ctx -> {
          Date dataHora = (Date) ctx.getSource();
          if (dataHora == null)
            return null;
          return new java.text.SimpleDateFormat("HH:mm").format(dataHora);
        }).map(source.getDataHora(), destination.getHora());
      }
    });

    return mapper;
  }
  
}
