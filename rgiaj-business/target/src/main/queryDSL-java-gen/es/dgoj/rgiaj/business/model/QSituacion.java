package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSituacion is a Querydsl query type for Situacion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSituacion extends EntityPathBase<Situacion> {

    private static final long serialVersionUID = -859718979;

    public static final QSituacion situacion = new QSituacion("situacion");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath situacionEmp = createString("situacionEmp");

    public final StringPath situacionLocal = createString("situacionLocal");

    public final StringPath situacionMaq = createString("situacionMaq");

    public final StringPath situacionModelo = createString("situacionModelo");

    public final StringPath situacionPersona = createString("situacionPersona");

    public final StringPath tipoSituacion = createString("tipoSituacion");

    public QSituacion(String variable) {
        super(Situacion.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QSituacion(Path<? extends Situacion> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QSituacion(PathMetadata<?> metadata) {
        super(Situacion.class, metadata);
    }

}

