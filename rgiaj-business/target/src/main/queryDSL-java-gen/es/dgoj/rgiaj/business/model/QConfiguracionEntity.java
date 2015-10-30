package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QConfiguracionEntity is a Querydsl query type for ConfiguracionEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QConfiguracionEntity extends EntityPathBase<ConfiguracionEntity> {

    private static final long serialVersionUID = -512699656;

    public static final QConfiguracionEntity configuracionEntity = new QConfiguracionEntity("configuracionEntity");

    public final StringPath clave = createString("clave");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> idConfiguracion = createNumber("idConfiguracion", Long.class);

    public final StringPath valor = createString("valor");

    public QConfiguracionEntity(String variable) {
        super(ConfiguracionEntity.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QConfiguracionEntity(Path<? extends ConfiguracionEntity> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QConfiguracionEntity(PathMetadata<?> metadata) {
        super(ConfiguracionEntity.class, metadata);
    }

}

