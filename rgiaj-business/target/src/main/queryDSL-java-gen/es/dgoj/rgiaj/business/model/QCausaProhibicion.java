package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCausaProhibicion is a Querydsl query type for CausaProhibicion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCausaProhibicion extends EntityPathBase<CausaProhibicion> {

    private static final long serialVersionUID = 1791611655;

    public static final QCausaProhibicion causaProhibicion = new QCausaProhibicion("causaProhibicion");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QCausaProhibicion(String variable) {
        super(CausaProhibicion.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QCausaProhibicion(Path<? extends CausaProhibicion> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QCausaProhibicion(PathMetadata<?> metadata) {
        super(CausaProhibicion.class, metadata);
    }

}

