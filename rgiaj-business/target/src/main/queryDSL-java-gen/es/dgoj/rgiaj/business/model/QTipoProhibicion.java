package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTipoProhibicion is a Querydsl query type for TipoProhibicion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTipoProhibicion extends EntityPathBase<TipoProhibicion> {

    private static final long serialVersionUID = -219182028;

    public static final QTipoProhibicion tipoProhibicion = new QTipoProhibicion("tipoProhibicion");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QTipoProhibicion(String variable) {
        super(TipoProhibicion.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QTipoProhibicion(Path<? extends TipoProhibicion> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QTipoProhibicion(PathMetadata<?> metadata) {
        super(TipoProhibicion.class, metadata);
    }

}

